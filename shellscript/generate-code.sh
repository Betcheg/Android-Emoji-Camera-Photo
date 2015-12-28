#!/bin/sh

HERE=$(cd "$(dirname "$0")" && pwd)

source="/home/bastien/github/emojione/assets/png_512x512"
output="LetTheMontageBegin.java"
xmloutput="emojilist.xml"
#==========================================
#  Fonctions
#==========================================

getArguments() {

  while true; do
    case "$1" in

      "--source" )
      source="$2"
      shift 2
      ;;

      "--output" )
      output="$2"
      shift 2
      ;;
      *)

      break
      ;;
    esac
  done
}

generateJAVA() {
  . "$HERE/./utilities.sh"
  (
  genererDebut
  for j in "$source/"*".png"; do
    genererTableau $j
  done
  genererPreTableau
  for j in "$source/"*".png"; do
    genererTableauHauteur $j
  done
  genererInterTableau
  for j in "$source/"*".png"; do
    genererTableauLargeur $j
  done
  genererSuite
  for j in "$source/"*".png"; do
    genererVariables $j
  done
  genererApresVariables
  for j in "$source/"*".png"; do
    genererFindViewById $j
  done
  genererApresFind
  for j in "$source/"*".png"; do
    genererSetOnClickListener $j
  done
  genererFin

  ) > "$PWD/LetTheMLGBegin.java"
}

generateXML() {
  . "$HERE/./utilities.sh"
  (
  XMLbegin

  for j in "$source/"*".png"; do
    if [ $(( $modulo % 4 )) -eq 0 ]
      then
      echo "<TableRow>"
    fi
    XMLbouton $j $modulo
    if [ $(( $modulo % 4 )) -eq 3 ]
      then
      echo "</TableRow>"
    fi
    modulo=$(($modulo + 1))
  done

  XMLend

  ) > "$PWD/$xmloutput"
}
#======== Fonctionnement logique du script ==========#

# On récupère tous les arguments passés en paramètre
getArguments "$@"

# On génère la page HTML qui affiche la galerie
generateJAVA
generateXML

cp LetTheMontageBegin.java /home/bastien/AndroidStudioProjects/EmojiMontage/app/src/main/java/betcheg/EmojiCamera/LetTheMontageBegin.java

cp emojilist.xml /home/bastien/AndroidStudioProjects/EmojiMontage/app/src/main/res/layout/emojilist.xml
