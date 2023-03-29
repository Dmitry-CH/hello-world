(ns helloworld.type-flourish
  (:require ["splitting/dist/splitting.min" :as splitting]))

;; https://splitting.js.org/

#_(def Char {:el nil
             :index 0
             :original ""})

#_(def Word {:el nil
             :index 0
             :original ""})

#_(def Shuffle {:el nil
                :chars []
                :words []
                :totalChars 0
                :totalWords 0})


(def ^:dynamic *lang* "en")


(def letters-and-symbols-en
  ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "!", "@", "#", "$", "&", "*", "(", ")", "-", "_", "+", "=", "/", "[", "]", "{", "}", ";", ":", "<", ">", ",", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"])

(def letters-and-symbols-ru
  ["а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я", "!", "@", "#", "$", "&", "*", "(", ")", "-", "_", "+", "=", "/", "[", "]", "{", "}", ";", ":", "<", ">", ",", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"])

(defn- get-random-char []
  (let [xs (case *lang*
             "en" letters-and-symbols-en
             "ru" letters-and-symbols-ru
             :else letters-and-symbols-en)
        len (count xs)]

    (nth xs (rand-int len))))


(defn- set-char! [char val]
  (set! (.-innerHTML (:el char)) val))

(defn- clear-chars! [chars]
  (doseq [char chars]
    (set-char! char "&nbsp")))


(defn- create-char [idx itm]
  {:el itm
   :index idx
   :original (.getAttribute itm "data-char")})

(defn- create-word [idx itm]
  {:el itm
   :index idx
   :original (.getAttribute itm "data-char")})


;; -------------------------
;; ...

(defn flourish! [el]
  (let [results (first (splitting #js{:target el :by "chars"}))
        el (.-el results)
        chars (.-chars results)
        words (.-words results)]

    {:el el
     :chars (map-indexed create-char chars)
     :words (map-indexed create-word words)
     :totalChars (count chars)
     :totalWords (count words)}))


(defmulti flourish-fx (fn [fx _] fx))


(defn- fx-3
  ([char max]
   (fx-3 char max 1))
  ([char max iteration]
   (if-not (= iteration max)
     (do
       (set-char! char (get-random-char))
       (js/setTimeout (fn []
                        (fx-3 char max (inc iteration)))
                      200))
     (set-char! char (:original char)))))

(defmethod flourish-fx :fx3
  [_ {:keys [chars]}]

  (let [MAX_ITERATIONS 10]
    (clear-chars! chars)

    (doseq [char chars]
      (js/setTimeout (fn []
                       (fx-3 char MAX_ITERATIONS))
                     (rand-int 3000)))))
