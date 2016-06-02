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
  :process-input
  (fn [db _]
    (-> db
        (update-in ,,, [:outputs] conj (awesome/accept-input (:input-text db) db))
        (assoc ,,, :busy? false)
        (assoc ,,, :input-text ""))))

(re-frame/register-handler
  :submit-input
  (fn [db _]
    ; might take a while. See
    ; https://github.com/Day8/re-frame/wiki/Solve-the-CPU-hog-problem#forcing-a-one-off-render
    (re-frame/dispatch ^:flush-dom [:process-input])
    (assoc db :busy? true)))
