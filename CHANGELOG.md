# Changelog

Todos los cambios importantes en este proyecto serán documentados en este archivo.

Este proyecto sigue versionado semántico (SemVer) y el formato de [Keep a Changelog](https://keepachangelog.com/es-ES/1.0.0/).

---
## [2.0.0] - 2026-10-08
### Changed
- Se eliminaron las anotaciones `@Query` del model `Pago`, al considerarse innecesarias.

### Removed
- Se eliminan los model `Cheque` y `Cheque devuelto` del proyecto, al considerarse innecesarios.
- Se eliminan los metodos `buscarTodos()`, `buscarPorFactura(Integer id)` y `buscarPorClienteFechas(Cliente c, LocalDate startDate, LocalDate endDate)` de `PagoDAO`,
debido a que se consideran personalizaciones del DAO y deberían implementarse directamente en el proyecto que depende de `gestion-core`.

## [1.0.3] - 2026-10-06
### Added
- Se agregan los model `Complemento de pago`, `Serie de complemento de pago` y `Status Serie de complemento de pago`.
- Se agrega el atributo `Forma de pago` al model `Pago`.

### Removed
- Se elimina la relación física del model `Cheque` y `Cheque devuelto` con el model `Pago`.

## [1.0.2] - 2026-09-14
### Added
- Creación del archivo CHANGELOG.md
- Creación del archivo LICENSE

### Change
- Dentro del modelo de Ordenes de Salida, se modifica el atributo Observaciones para el ajuste de caracteres que recibe

## Nota
Los cambios previos a esta versión (desde el inicio del proyecto) no están documentados por tratarse de la fase inicial de desarrollo.
