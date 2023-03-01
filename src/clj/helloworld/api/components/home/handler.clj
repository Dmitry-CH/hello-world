(ns helloworld.api.components.home.handler
  (:require [clojure.tools.logging :as log]
            [ring.util.http-response :as http-response]))

(defn home [_]
  (log/debug "[Handler] Home page")

  (-> (http-response/ok "home")
      (assoc-in [:headers "Content-Type"] "text/html;charset=utf-8")))
