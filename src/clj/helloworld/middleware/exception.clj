(ns helloworld.middleware.exception
  (:require [ring.util.http-response :as http-response]))


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
