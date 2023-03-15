(ns helloworld.pages.home.routes
  (:require [integrant.core :as ig]
            [helloworld.pages.home.handler :as handler]))


(defmethod ig/init-key :pages/home
  [_ {:keys [path]}]
  [path
   {:get handler/home}])
