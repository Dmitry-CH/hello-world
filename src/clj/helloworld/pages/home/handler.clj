(ns helloworld.pages.home.handler
  (:require [clojure.tools.logging :as log]
            [ring.util.http-response :as http-response]
            [helloworld.pages.home.view :as view]))


(defn home [request]
  (log/debug "[Handler] Home page")

  (let [tr (:tempura/tr request)]
    (try
      (-> (view/render {:lang  (tr [:page/lang])
                        :title (tr [:page/title])
                        :content {:name {:title (tr [:author.name/title])
                                         :value (tr [:author.name/value])}
                                  :profession {:title (tr [:author.profession/title])
                                               :value (tr [:author.profession/value])}
                                  :bio {:title (tr [:author.bio/title])
                                        :value (tr [:author.bio/value])}}})
          http-response/ok
          (assoc-in [:headers "Content-Type"] "text/html;charset=utf-8"))
      (catch Exception e
        (throw e)))))
