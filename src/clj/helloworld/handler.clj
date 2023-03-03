(ns helloworld.handler
  (:require [integrant.core :as ig]
            [reitit.ring :as ring]
            [ring.util.http-response :as http-response]))

(defn exception-handler [^Exception e]
  (let [mess (.getMessage e)]
    (http-response/internal-server-error
     (or mess "Server Error"))))

(defn wrap-exception [handler]
  (fn [request]
    (try
      (handler request)
      (catch Throwable e
        (exception-handler e)))))

(def exception-middleware
  {:name ::exception
   :wrap wrap-exception})

(defmethod ig/init-key :handler/ring
  [_ {:keys [router]}]
  (ring/ring-handler
   (ring/router router
                {:data {:middleware [exception-middleware]}})
   (ring/routes
    (ring/create-resource-handler {:path "/"})
    (ring/create-default-handler))))
