(ns helloworld.middleware.cookies
  (:require [ring.middleware.cookies :refer [wrap-cookies]]))


(def cookies-middleware
  {:name ::cookies
   :wrap wrap-cookies})
