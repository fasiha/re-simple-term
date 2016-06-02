(ns re-simple-term.views
    (:require [re-frame.core :as re-frame]))

(defn busy-panel []
  (let [busy-sub (re-frame/subscribe [:busy?])]
    (fn []
      (if @busy-sub
        [:div "Busy…"]))))
(defn output-panel []
  (let [outputs-sub (re-frame/subscribe [:outputs])]
    (fn []
      (let [outputs @outputs-sub]
        ; if this ever becomes slow, see for the React + re-frame way to do this
        ; http://stackoverflow.com/a/37186230/500207
        (into [:div#outputs]
              (map (fn [output] [:div.output output])
                   outputs))))))

(defn input-panel []
  (let [input-text-sub (re-frame/subscribe [:input-text])]
    (fn []
      [:div
       [:textarea {:cols 30
                   :placeholder "Enter input here…"
                   :value @input-text-sub
                   :onChange #(re-frame/dispatch [:change-input (-> % .-target .-value)])}]
       [:button {:onClick #(re-frame/dispatch [:submit-input])} "Submit"]])))

(defn main-panel []
  [:div [input-panel] [busy-panel] [output-panel]])
