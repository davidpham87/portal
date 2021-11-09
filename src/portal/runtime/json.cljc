(ns portal.runtime.json
  (:refer-clojure :exclude [read]))

(defn write [value]
  #?(:bb   (cheshire.core/generate-string value)
     :clj  ((requiring-resolve 'clojure.data.json/write-str) value)
     :cljs (.stringify js/JSON value)))

(defn read [string]
  #?(:bb   (cheshire.core/parse-string string)
     :clj  ((requiring-resolve 'clojure.data.json/read-str) string)
     :cljs (.parse js/JSON string)))

(defn parse-stream [stream]
  #?(:bb (cheshire.core/parse-stream stream keyword)
     :clj ((requiring-resolve 'clojure.data.json/read) stream
           :key-fn keyword)))
