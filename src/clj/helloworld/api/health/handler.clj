(ns helloworld.api.health.handler
  (:require [clojure.tools.logging :as log]
            [ring.util.http-response :as http-response]))


(defn health [_]
  (log/debug "[Handler] API health")

  (-> (http-response/ok "ok")
      (assoc-in [:headers "Cache-Control"] "no-cache")
      (assoc-in [:headers "Content-Type"] "text/html;charset=utf-8")))
