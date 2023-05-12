(ns helloworld.api.lang.handler
  (:require [clojure.data.json :as json]
            [clojure.tools.logging :as log]
            [ring.util.http-response :as http-response]))


(def default-lang "ru")

(def ^:private lang-switch
  {"en" "ru"
   "ru" "en"})


(defn lang [request]
  (log/debug "[Handler] API lang")

  (let [cookies (:cookies request)
        lang (get-in cookies ["lang" :value] default-lang)]

    (-> (http-response/ok)
        (assoc-in [:cookies "lang"] {:value (lang-switch lang)
                                     :path "/"})
        #_(assoc-in [:headers "HX-Refresh"] "true")
        (assoc-in [:headers "HX-Trigger"] (json/write-str {:langSwitch (lang-switch lang)})))))
