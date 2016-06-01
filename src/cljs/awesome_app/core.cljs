(ns awesome-app.core
  (:require [clojure.string :as string]))

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

; This is the gateway into your app. In this extremely trivial example,
; depending on how many inputs the user has submitted, the output will be either
; a reversed string or an enumerated list of characters.
(defn accept-input [s & [db]]
  (if (-> db :outputs count odd?)
    (just-reverse s)
    (enumerate s))))

