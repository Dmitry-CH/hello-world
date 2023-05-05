(ns helloworld.views.layout
  (:require [clojure.java.io :as io]
            [selmer.parser :as parser]))


(parser/set-resource-path! (io/resource "public/"))


(defn render
  "Базовый шаблон страницы.
   
   Usage:
   ```
   (render {:body \"<div>...</div>\"})
   ```
   
   Keys:
   | key     | description |
   |---------|-------------|
   | `:lang` | Язык страницы
   | `:head` | Вставка в `<head>`
   | `:body` | Вставка в `<body>`"
  [params]
  (parser/render-file "default.html" params))
