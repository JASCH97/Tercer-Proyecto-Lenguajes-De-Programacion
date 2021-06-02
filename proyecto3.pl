:- dynamic pista/2.
:- dynamic personaje/5.
:- dynamic culpable/5.
:- dynamic pistaRandom/2.
:- dynamic caraDado/2.
:- dynamic caraDadoRandom/1.
:- use_module(library(random)).


%Al numerar o ponerles id a los personajes, se facilita el crear un culpable random.
personaje(1,emily,azul,cuernos,trajeDoctor).
personaje(2,aurelio,rojo,cuernos,trajeBlanco).
personaje(3,joan,verde,cuernos,trajePolicia).
personaje(4,alvaro,rosado,cuernos,trajeNegro).
personaje(5,eduardo,azul,queso,trajePolicia).
personaje(6,samanta,rojo,huevo,trajeBlanco).
personaje(7,alex,rojo,queso,trajeDoctor).
personaje(8,leandro,rosado,banano,trajeDoctor).
personaje(9,carlos,azul,huevo,trajeNegro).
personaje(10,tomas,verde,huevo,trajePolicia).
personaje(11,esteban,verde,queso,trajeNegro).
personaje(12,luis,rosado,huevo,trajeDoctor).
personaje(13,jimena,azul,banano,trajeBlanco).
personaje(14,marco,rojo,banano,trajeNegro).
personaje(15,daniela,verde,banano,trajePolicia).
personaje(16,jaime,rosado,queso,trajeBlanco).

%Al numerar las pistas puedo usar una relacion para obtener una random. Hace falta saber como eliminarla e igual poder obtener el nombre en Java.
pista(1,azul).
pista(2,rojo).
pista(3,verde).
pista(4,rosado).
pista(5,cuernos).
pista(6,queso).
pista(7,huevo).
pista(8,banano).
pista(9,trajeDoctor).
pista(10,trajePolicia).
pista(11,trajeNegro).
pista(12,trajeBlanco).


%se escoge un culpable random entre los personajes y se cambia por el culpable anterior.
culpableRandom():-
    random(1, 17, R),
    personaje(R,Nombre,Acc1,Acc2,Acc3),
    assertz(culpable(R,Nombre,Acc1,Acc2,Acc3)).

%relacion para probar que el culpable se elije random. Tambien por si accidentalmente se crea mas de un culpable, se puedan borrar.
quitarCulpable():-
    culpable(Id,Name,A1,A2,A3),
    retract(culpable(Id,Name,A1,A2,A3)),!.


%relacion que decifra si una pista conlleva al culpable o no.
decifradorPistas(Pista):-
    culpable(Id,_,_,_,_),           %se obtiene el Id del culpable
    decifradorPistasAux(Pista,Id).

decifradorPistasAux(Pista,Id):-
    personaje(Id,_,Acc1,_,_),
    Acc1 = Pista,!.

decifradorPistasAux(Pista,Id):-
    personaje(Id,_,_,Acc2,_),
    Acc2 = Pista,!.

decifradorPistasAux(Pista,Id):-
    personaje(Id,_,_,_,Acc3),
    Acc3 = Pista,!.


%relacion que genera una pista aleatoria tomando una de las existentes
generarPistaRandom():-
    random(1,13,R),  %R es un random entre 1 y 12
    pista(R,Pista),
    assertz(pistaRandom(R,Pista)).

%relacion que elimina la pistaRandom existente
quitarPistaRandom():-
    pistaRandom(R,Pista),
    retract(pistaRandom(R,Pista)).

%el primer argumento en dado, representa la cara del mismo. El segundo argumento, lo que muestra dicha cara
caraDado(1,ojo).
caraDado(2,huella).
caraDado(3,ojo).
caraDado(4,huella).
caraDado(5,ojo).
caraDado(6,huella).

%relacion que tira un dado y crea un resultado dinamico de una cara random en caraDadoRandom
tirarDado():-
    random_between(1, 6, R),
    caraDado(R,Cara),
    assertz(caraDadoRandom(Cara)).    


descartarCaraDadoRandom():-
    caraDadoRandom(Cara),
    retract(caraDadoRandom(Cara)).



descartarPersonaje(Nombre):-
    personaje(Id,Nombre,Acc1,Acc2,Acc3),
    retract(personaje(Id,Nombre,Acc1,Acc2,Acc3)),!.