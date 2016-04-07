# study_jam_ascendio2016

PlayMe, muestre una lista todos los audios existentes usando un json local y archivos locales, se pueda ver el detalle de cada uno y todo de forma asíncrona:

Conceptos:

Activities.
Fragments
Envío de data entre actividades.
AsyncTask.
Handlers.
Callbacks (Listeners)
Manejo de recursos locales. (json, mp3, ogg, bitmaps)
Lista con ViewHolder.

Flujo:

Pantalla inicial donde lista los audios para reproducir (sin servicio, solo audios cortos) y que cargan usando un AsyncTask (todo local)
Al hacer tap en uno abre un detalle del audio y reproduce el sonido automáticamente utilizando un handler.
Cada audio tiene una imagen de preview.
Un botón que se pone en “pause” cuando esta reproduciendo y en “play” cuando no.

Que se le va a dar a los presentes:

El json con los recursos.
El template base.
El github.
