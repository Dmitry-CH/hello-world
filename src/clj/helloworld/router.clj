(ns helloworld.router
  (:require [integrant.core :as ig]))


(defmethod ig/init-key :router/core
  [_ {:keys [base-path routes]
      :or {base-path ""}}]
  [base-path
   (into [] routes)])
