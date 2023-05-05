(ns helloworld.api.home.routes
  (:require [integrant.core :as ig]
            [helloworld.api.home.handler :as handler]))


(defmethod ig/init-key :pages/home
  [_ {:keys [path]}]
  [path
   {:get handler/home}])
