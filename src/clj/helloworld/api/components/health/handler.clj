(ns helloworld.api.components.health.handler
  (:require [ring.util.http-response :as http-response]))

(defn health [_]
  (-> (http-response/ok "ok")
      (assoc-in [:headers "Cache-Control"] "no-cache")
      (assoc-in [:headers "Content-Type"] "text/html;charset=utf-8")))
