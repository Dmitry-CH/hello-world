(ns helloworld.handler
  (:require [integrant.core :as ig]
            [reitit.ring :as ring]
            [helloworld.middleware.exception :refer [exception-middleware]]
            [helloworld.middleware.i18n :refer [i18n-middleware]]))


(defmethod ig/init-key :handler/ring
  [_ {:keys [router]}]
  (ring/ring-handler
   (ring/router router
                {:data {:middleware [exception-middleware
                                     i18n-middleware]}})
   (ring/routes
    (ring/create-resource-handler {:path "/"})
    (ring/create-default-handler))))
