(ns helloworld.api.lang.handler
  (:require [clojure.tools.logging :as log]
            [ring.util.http-response :as http-response]))


(def ^:private lang-switch
  {"en" "ru"
   "ru" "en"})

(defn lang [request]
  (log/debug "[Handler] API lang")
  
  (let [cookies (:cookies request)
        lang (get-in cookies ["lang" :value] "ru")]
    (-> (http-response/ok)
        (assoc-in [:cookies "lang"] {:value (lang-switch lang)
                                     :path "/"
                                     #_#_:http-only true})
        (assoc-in [:headers "HX-Refresh"] "true"))))
