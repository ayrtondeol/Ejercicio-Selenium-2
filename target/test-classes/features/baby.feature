Feature: buscar en google la letra de una cancion y contar la cantidad de veces que dice una palabra

Scenario Outline: buscar la letra de una cancion y cuento cuantas veces dice algo
Given estoy en google
When busco la letra de <cancion>
And cuento cuantas veces dice <algo>
Then obtengo la cantidad de veces que lo dice

Examples:
| cancion                | algo   |
| "baby keem range brothers" | "mornin" |
| "californication" | "californication" |
| "baby justin bieber" | "baby" |
| "el hit horvilleur" | "hit" |