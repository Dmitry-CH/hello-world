(ns helloworld.api.components.home.route
  (:require [integrant.core :as ig]
            [helloworld.api.components.home.handler :as handler]))

(defmethod ig/init-key :router.routes/home
  [_ {:keys [path]}]
  [path
   {:get handler/home}])
