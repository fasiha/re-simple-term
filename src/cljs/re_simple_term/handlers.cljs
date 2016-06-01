(ns re-simple-term.handlers
    (:require [re-frame.core :as re-frame]
              [re-simple-term.db :as db]))

(re-frame/register-handler
 :initialize-db
 (fn  [_ _]
   db/default-db))
