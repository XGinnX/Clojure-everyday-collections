(ns loja.aula4
  (:require [loja.db :as l.db]
            [loja.logic :as l.logic]))

(println (l.db/todos-os-pedidos))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "RESUMO" resumo)
  (println  "Ordenado" (sort-by :preco-total resumo))
  (println  "Ordenado ao contrário" (reverse(sort-by :preco-total resumo)))
  (println "Ordenado por ID" (sort-by :usuario-id resumo))

  (println (get-in pedidos [0 :itens :mochila :quantidade]))
  )

(defn resumo-por-usuario-ordenado
  [pedidos]
  (->> pedidos
       (l.logic/resumo-por-usuario)
       (sort-by :preco-total)))

( let [pedidos (l.db/todos-os-pedidos)
     resumo (resumo-por-usuario-ordenado pedidos)]
(println "RESUMO" resumo)
; Coleta o primeiro elemento
(println "Primeiro" (first resumo))
; Coleta o segundo elemento
(println "Segundo" (second resumo))
; Coleta Tudo, menos o primeiro elemento
(println "Resto" (rest resumo))
; Coleta o total dos elementos
(println "Total" (count resumo))
; Coleta a Classe do elemento
(println "class" (class resumo))
; Coleta um elemento específico
(println "nth 1" (nth resumo 1))
; Coleta um elemento específico
(println "get 1" (get resumo 1))
; Coleta um-dois elementos específicos
(println "take" (take 2 resumo)))

(defn top-2
  [resumo]
  (take 2 resumo))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "RESUMO" resumo)
  (println "TOP-2" (top-2 resumo)))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "> 500 filter" (filter #(> (:preco-total %) 500) resumo))
  (println "> 500 filter empty not" (not(empty? (filter #(> (:preco-total %) 500) resumo))))
  (println "> 500 some" (some #(> (:preco-total %) 500) resumo))
  )

; #() - Função anonima
; Parametros são anonimos
; #([parametros]) => #()