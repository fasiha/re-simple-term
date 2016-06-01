(ns re-simple-term.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/register-sub :input-text (fn [db] (reaction (:input-text @db))))
(re-frame/register-sub :outputs (fn [db] (reaction (:outputs @db))))
