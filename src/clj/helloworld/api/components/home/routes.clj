(ns helloworld.api.components.home.routes
  (:require [integrant.core :as ig]
            [helloworld.api.components.home.handler :as handler]))

(defmethod ig/init-key :api.components/home
  [_ {:keys [path]}]
  [path
   {:get handler/home}])
