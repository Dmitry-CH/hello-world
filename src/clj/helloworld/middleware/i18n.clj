(ns helloworld.middleware.i18n
  (:require [taoensso.tempura :as tempura]))


(def tconfig
  {:default-locale :en
   
   :dict {:en {:__load-resource "locales/en/translit.edn"} 
          :ru {:__load-resource "locales/ru/translit.edn"}}})

(defn wrap-i18n [handler]
  (tempura/wrap-ring-request handler {:tr-opts tconfig}))


(def i18n-middleware
  {:name ::i18n
   :wrap wrap-i18n})
