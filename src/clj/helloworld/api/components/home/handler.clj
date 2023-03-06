(ns helloworld.api.components.home.handler
  (:require [clojure.tools.logging :as log]
            [ring.util.http-response :as http-response]
            [helloworld.pages.components.home.core :refer [render-home]]))

(defn home [_]
  (log/debug "[Handler] Home page")

  (try
    (let [page (render-home)]
      (-> page
          http-response/ok
          (assoc-in [:headers "Content-Type"] "text/html;charset=utf-8")))
    (catch Exception e
      (throw e))))
