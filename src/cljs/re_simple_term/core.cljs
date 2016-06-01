(ns re-simple-term.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [re-simple-term.handlers]
              [re-simple-term.subs]
              [re-simple-term.views :as views]
              [re-simple-term.config :as config]))

(when config/debug?
  (println "dev mode"))

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init [] 
  (re-frame/dispatch-sync [:initialize-db])
  (mount-root))
