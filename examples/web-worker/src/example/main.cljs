(ns example.main
  (:require [portal.web :as p]
            [portal.runtime.rpc :as rpc]))

(def portal (p/open))

(def worker (js/Worker. "out/worker.js"))

(rpc/connect (:session portal) worker)

(tap> :hello-from-main)
