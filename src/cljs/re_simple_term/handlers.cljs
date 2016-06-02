(ns re-simple-term.handlers
    (:require [re-frame.core :as re-frame]
              [re-simple-term.db :as db]
              [awesome-app.core :as awesome]))

(re-frame/register-handler
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/register-handler
  :change-input
  (fn [db [_ text]]
    (assoc db :input-text text)))

(re-frame/register-handler
  :submit-input
  (fn [db _]
    (-> db
        (update-in ,,, [:outputs] conj (awesome/accept-input (:input-text db) db))
        (assoc ,,, :input-text ""))))
