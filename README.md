# 🏥 Minsa System

**Minsa System** es una aplicación de escritorio desarrollada en Java orientada a la gestión de metas de salud asignadas a obstetras, facilitando el seguimiento y control dentro de los programas de atención del Ministerio de Salud (MINSA).

## 📌 Características Principales

- Registro y gestión de usuarios (rol administrador y obstetra).
- Creación y asignación de metas anuales/mensuales por obstetra.
- Visualización de progreso de metas mediante gráficos y tablas.
- Generación de reportes en PDF.
- Interfaz visual desarrollada con Swing y NetBeans.

## 🧩 Estructura del Proyecto

```

Minsa System/
├── build.xml               # Archivo de construcción (NetBeans / Ant)
├── manifest.mf            # Archivo de manifiesto Java
├── src/
│   ├── clases/            # Clases de lógica y acceso a datos (DAO)
│   ├── ventanas/          # Interfaces gráficas (formularios y controladores)
│   └── images/            # Recursos gráficos usados en la interfaz

```

## 📂 Módulos Destacados

- `CrearMeta.java`: Permite definir metas a cumplir dentro de un programa.
- `AsignarMeta.java`: Asocia metas a un obstetra específico.
- `RegistrarUsuarios.java`: Alta de nuevos usuarios al sistema.
- `GestionarMetas.java`: Edición y seguimiento de metas asignadas.
- `Conexion.java`: Clase para conexión a la base de datos.

## ⚙️ Tecnologías Utilizadas

- Java SE
- NetBeans (IDE)
- Swing (Interfaz Gráfica)
- JDBC (Acceso a base de datos)
- JasperReports (para exportación PDF, si aplica)
- Imágenes SVG/PNG para experiencia de usuario

## 🚀 Cómo ejecutar

1. Abrir el proyecto en **NetBeans**.
2. Configurar la base de datos (si no está integrada).
3. Ejecutar desde el botón "Run".
4. Acceder con credenciales predeterminadas (modificables desde base de datos).

## 👥 Roles del Sistema

- **Administrador**: Crea metas, asigna, edita, registra usuarios, ve reportes.
- **Obstetra**: Consulta y actualiza sus propias metas y atención realizadas.

## 🛑 Limitaciones

- Aplicación de escritorio (no es web ni móvil).
- Uso local (requiere entorno Java y NetBeans configurado).
- No incluye autenticación con cifrado robusto (si aplica).
