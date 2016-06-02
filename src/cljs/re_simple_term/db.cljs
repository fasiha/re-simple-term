(ns re-simple-term.db)

(def default-db
  {:input-text ""
   :outputs '() ; new value will be `conj` to this seq (pushed onto front)
   :busy? false
   })
