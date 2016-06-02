(ns re-simple-term.db)

(def default-db
  {:input-text "{:a 123 :b -1}"
   :outputs '() ; new value will be `conj` to this seq (pushed onto front)
   :busy? false
   })
