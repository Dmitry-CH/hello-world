(ns helloworld.api.components.home.handler
  (:require [clojure.tools.logging :as log]
            [ring.util.http-response :as http-response]
            [helloworld.api.views.pages.home :as home]))

(defn home [_]
  (log/debug "[Handler] Home page")

  (try
    (let [page (home/render)]
      (-> page
          http-response/ok
          (assoc-in [:headers "Content-Type"] "text/html;charset=utf-8")))
    (catch Exception e
      (throw e))))
