(ns helloworld.pages.home.handler
  (:require [clojure.tools.logging :as log]
            [ring.util.http-response :as http-response]
            [helloworld.pages.home.view :as view]))


(defn home [request]
  (log/debug "[Handler] Home page")

  (let [tr (:tempura/tr request)]
    (try
      (-> (view/render {:lang (tr [:page/lang "En"])})
          http-response/ok
          (assoc-in [:headers "Content-Type"] "text/html;charset=utf-8"))
      (catch Exception e
        (throw e)))))
