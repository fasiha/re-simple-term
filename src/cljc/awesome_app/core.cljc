(ns awesome-app.core
  (:require [clojure.string :as string]
            #?(:cljs [cljs.reader])))

; Put all your super-awesome library code here. Re-frame will call
; `accept-input` with a string from the browser and the re-frame app database,
; and its return value will be fed verbatim back to ClojureScript/re-frame.

; Your app might return just a string, which will be packed into a <div> HTML
; tag
(defn just-reverse [s]
  (string/reverse s))

; Or it might return a Hiccup vector which re-frame/Reagent/React will render to
; HTML. In this case, <ol><li>...</ol>
(defn enumerate [s]
  (into [:ol]
        (map (fn [element] [:li element])
             (string/split s ""))))

; A function might take a long time to run...
(defn now []
  #?(,,,
       :cljs (.getTime (js/Date.))
       :clj (java.lang.System/currentTimeMillis)))
(defn cpu-hog-function [s]
  (let [start (now)
        res (str s " - CPU hog result: " (apply + (take 1000000 (range))))
        end (now)]
    (str res " - elapsed ms: " (- end start))))

; A function might parse your input into a Clojure data structure
(defn rs [s]
  #?@(,,,
       :cljs (cljs.reader/read-string s)
       :clj (read-string s)))
(defn parse-string [s]
  (count (rs s)))

; This is the gateway into your app. In this extremely trivial example,
; depending on how many inputs the user has submitted, the output will be either
; a reversed string or an enumerated list of characters. In this way, your
; application can know about the other commands the user has run.
(defn accept-input [s & [db]]
  (condp = (-> db :outputs count (mod 4))
    0 (just-reverse s)
    1 (cpu-hog-function s)
    2 (enumerate s)
    3 (parse-string s)
    "luigi gonna win"))

