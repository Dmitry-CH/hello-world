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


(def letters-and-symbols
  ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "!", "@", "#", "$", "&", "*", "(", ")", "-", "_", "+", "=", "/", "[", "]", "{", "}", ";", ":", "<", ">", ",", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"])

(defn- get-random-char []
  (nth letters-and-symbols
       (rand-int (count letters-and-symbols))))


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
  (let [results (first (splitting (clj->js {:target el :by "chars"})))
        el (.-el results)
        chars (.-chars results)
        words (.-words results)]

    {:el el
     :chars (map-indexed create-char chars)
     :words (map-indexed create-word words)
     :totalChars (count chars)
     :totalWords (count words)}))


(defmulti flourish-fx (fn [fx _] fx))

;; ...

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
      ;; ...
      (js/setTimeout (fn []
                       (fx-3 char MAX_ITERATIONS))
                     (rand-int 3000)))))
