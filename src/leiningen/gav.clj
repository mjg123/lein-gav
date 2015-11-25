(ns leiningen.gav
  (:require [clojure.string :as s]))

(defn gav
  "Print a project's maven coordinates. Optionally supply format-string in which:
   {g} will be replaced by the group-id,
   {a} will be replaced by the artefact-id,
   {v} will be replaced by the version, and
   {gs} will be replaced by the group-id using / instead of . as the separator.

   The default format-string is '{g}\n{a}\n{v}'"
  [project & [format-string]]
  (let [{:keys [group name version]} project
        group-slashed (s/replace group \. \/)
        format-string (or format-string "{g}\n{a}\n{v}")
        formatted-string (-> format-string
                             (s/replace "{g}" group)
                             (s/replace "{gs}" group-slashed)
                             (s/replace "{a}" name)
                             (s/replace "{v}" version)
                             (s/replace "\\n" (System/getProperty "line.separator")))]
    (leiningen.core.main/info formatted-string)))
