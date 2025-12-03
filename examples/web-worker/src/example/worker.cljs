(ns example.worker
  (:require [portal.runtime :as rt]
            [portal.runtime.rpc :as rpc]))

(def session (rt/open-session {:session-id (random-uuid)}))

(rpc/connect session js/self)

(add-tap #'rt/update-value)

(tap> :hello-from-worker)
