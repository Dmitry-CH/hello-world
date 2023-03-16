(ns helloworld.middleware.exception
  (:require [ring.util.http-response :as http-response]))


(defn exception-response [^Exception e]
  (let [mess (.getMessage e)]
    (http-response/internal-server-error
     (or mess "Server Error"))))

(defn wrap-exception [handler]
  (fn
    ([request]
     (try
       (handler request)
       (catch Throwable e
         (exception-response e))))
    ([request respond raise]
     (try
       (handler request
                respond
                (fn [e] (raise (exception-response e))))
       (catch Throwable e
         (raise (exception-response e)))))))


(def exception-middleware
  {:name ::exception
   :wrap wrap-exception})
