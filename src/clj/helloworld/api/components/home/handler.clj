(ns helloworld.api.components.home.handler
  (:require [ring.util.http-response :as http-response]))

(defn home [_]
  (-> (http-response/ok "home")
      (assoc-in [:headers "Content-Type"] "text/html;charset=utf-8")))
