(ns helloworld.api.home.handler
  (:require [clojure.tools.logging :as log]
            [ring.util.http-response :as http-response]
            [helloworld.views.home.page :as page]))


(defn home [request]
  (log/debug "[Handler] Home page")

  (let [cookies (:cookies request)
        lang (get-in cookies ["lang" :value])
        tr (:tempura/tr request)]
    (try
      (-> (page/render {:lang lang
                        :tr tr})
          http-response/ok
          (assoc-in [:headers "Content-Type"] "text/html;charset=utf-8"))
      (catch Exception e
        (throw e)))))
