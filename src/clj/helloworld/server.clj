(ns helloworld.server
  (:require [integrant.core :as ig]
            [ring.adapter.jetty :refer [run-jetty]]))


(defmethod ig/init-key :server/ring-jetty
  [_ {:keys [port handler]}]
  (run-jetty handler {:port port
                      :join? false}))

(defmethod ig/halt-key! :server/ring-jetty
  [_ server]
  (.stop server))
