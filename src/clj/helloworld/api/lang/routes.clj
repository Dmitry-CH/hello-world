(ns helloworld.api.lang.routes
  (:require [integrant.core :as ig]
            [helloworld.api.lang.handler :as handler]))


(defmethod ig/init-key :api/lang
  [_ {:keys [path]}]
  [path
   {:get handler/lang}])
