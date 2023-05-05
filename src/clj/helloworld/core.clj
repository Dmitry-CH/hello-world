(ns helloworld.core
  (:require [integrant.core :as ig]
            ;; System
            [helloworld.config :as config]
            ;; App
            [helloworld.handler]
            [helloworld.server]
            ;; Routes
            [helloworld.router]
            [helloworld.api.health.routes]
            [helloworld.api.lang.routes]
            ;; Pages
            [helloworld.api.home.routes])
  (:gen-class))


;; Log uncaught exceptions in threads
#_(Thread/setDefaultUncaughtExceptionHandler nil)

(defonce system (atom nil))


(defn stop-app []
  (some-> @system
          ig/halt!)

  ;; Принудительно завершить `thread pools agent system`
  (shutdown-agents))


(defn start-app []
  (some->> (config/system-config)
          ig/prep
          ig/init
          (reset! system))

  ;; TODO: Добавить описание
  (.addShutdownHook (Runtime/getRuntime) (Thread. stop-app)))


(defn -main [& _]
  (start-app))
