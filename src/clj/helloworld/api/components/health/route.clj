(ns helloworld.api.components.health.route
  (:require [integrant.core :as ig]
            [helloworld.api.components.health.handler :as handler]))

(defmethod ig/init-key :router.routes/health
  [_ {:keys [path]}]
  [path
   {:get handler/health}])

;; (derive :router.routes/health :router/routes)
