# PsTa – Pharmacy Management System

**Name:** Aly Hamad  
**Projekttitel:** Pharmacy Management System (Apotheken-Verwaltungssystem)

---

## Projektbeschreibung

Dieses Projekt ist ein objektorientiertes Apotheken-Verwaltungssystem, das in Java implementiert wurde. Es modelliert verschiedene Produkttypen einer Apotheke – darunter rezeptfreie Medikamente, verschreibungspflichtige Medikamente und Kosmetikprodukte – mithilfe einer Vererbungshierarchie mit abstrakten Klassen, Schnittstellen und Polymorphie.

### Projektidee

Das System ermöglicht die Verwaltung eines Apothekenbestands mit folgenden Funktionalitäten:
- Produkte erstellen, vergleichen und klonen
- Verfügbarkeit prüfen und Produkte ausgeben (dispensieren)
- Bestandsverwaltung mit automatischer Exception-Behandlung bei fehlendem Vorrat
- Sortierung von Produkten nach Preis (Comparable) und nach Name (Comparator)

---

## Anwendungsfall

Ein Apotheker möchte seinen Produktbestand verwalten. Er legt verschiedene Produkte an (z. B. Paracetamol als rezeptfreies Medikament, Amoxicillin als verschreibungspflichtiges Medikament, Feuchtigkeitscreme als Kosmetik). Das System ermöglicht es, die Verfügbarkeit zu prüfen, Produkte auszugeben und den Gesamtpreis für eine bestimmte Menge zu berechnen. Wenn ein Produkt nicht in ausreichender Menge vorrätig ist, wird eine `OutOfStockException` geworfen. Die Produkte können nach Preis oder alphabetisch sortiert werden.

---

## Technische Anforderungen – Zuordnung

| Anforderung | Klasse(n) / Datei(en) |
|---|---|
| **Vererbungsstruktur** | `Product` → `Medicine` → `PrescriptionMedication`, `OvertheCounterMedication`; `Product` → `Cosmetic` |
| **Abstrakte Klasse** | `Product` (abstract), `Medicine` (abstract) |
| **Schnittstelle (Interface)** | `Sellable` – implementiert von `Product` |
| **Polymorphie** | `Main.java` – `ArrayList<Product>` enthält verschiedene Unterklassen |
| **Exceptions** | `OutOfStockException` (extends `RuntimeException`) – verwendet in `Product.dispense()` |
| **Collection Framework** | `Main.java` – `ArrayList<Product>`, `Collections.sort()` |
| **Comparable** | `Product` implementiert `Comparable<Product>` (Vergleich nach Preis) |
| **Comparator** | `CosmeticNameComparator` implementiert `Comparator<Cosmetic>` (Vergleich nach Name) |
| **Object-Methoden** | `toString()`, `equals()`, `hashCode()`, `clone()` in allen Produktklassen |
| **Javadoc** | Alle Klassen und Methoden sind dokumentiert |
| **JUnit Tests** | `ProductTest`, `CosmeticTest`, `IntegrationTest` |

---

## UML Klassendiagramm

```mermaid
classDiagram
    direction TB

    class Sellable {
        <<interface>>
        +checkAvailability(requiredQuantity : int) boolean
        +calculateTotal(quantity : int) double
        +dispense(quantity : int) void
    }

    class Cloneable {
        <<interface>>
    }

    class Comparable~Product~ {
        <<interface>>
        +compareTo(o : Product) int
    }

    class Comparator~Cosmetic~ {
        <<interface>>
        +compare(c1 : Cosmetic, c2 : Cosmetic) int
    }

    class Product {
        <<abstract>>
        -id : int
        -name : String
        -price : double
        -stockLevel : int
        +Product()
        +Product(id : int, name : String, price : double, stockLevel : int)
        +getId() int
        +setId(id : int) void
        +getName() String
        +setName(name : String) void
        +getPrice() double
        +setPrice(price : double) void
        +getStockLevel() int
        +setStockLevel(stockLevel : int) void
        +compareTo(p : Product) int
        +checkAvailability(requiredQuantity : int) boolean
        +calculateTotal(quantity : int) double
        +dispense(quantity : int) void
        +toString() String
        +equals(o : Object) boolean
        +hashCode() int
        +clone() Object
    }

    class Medicine {
        <<abstract>>
        -concentration : double
        -rec_dose : int
        -active_ingredient : String
        +Medicine()
        +Medicine(id : int, name : String, price : double, stockLevel : int, concentration : double, rec_dose : int, active_ingredient : String)
        +getConcentration() double
        +getRec_dose() int
        +getActive_ingredient() String
        +toString() String
        +equals(o : Object) boolean
        +hashCode() int
        +clone() Object
    }

    class PrescriptionMedication {
        -requiredDoctorSpecialty : String
        -isNarcotic : boolean
        +PrescriptionMedication()
        +PrescriptionMedication(id : int, name : String, price : double, stockLevel : int, concentration : double, rec_dose : int, active_ingredient : String, requiredDoctorSpecialty : String, isNarcotic : boolean)
        +getRequiredDoctorSpecialty() String
        +getIsNarcotic() boolean
        +toString() String
        +equals(o : Object) boolean
        +hashCode() int
        +clone() Object
    }

    class OvertheCounterMedication {
        -minimumAgelimit : int
        -isOnSale : boolean
        +OvertheCounterMedication(id : int, name : String, price : double, stockLevel : int, concentration : double, rec_dose : int, active_ingredient : String, minimumAgelimit : int, isOnSale : boolean)
        +getMinimumAgelimit() int
        +setMinimumAgelimit(minimumAgelimit : int) void
        +isOnSale() boolean
        +setOnSale(onSale : boolean) void
        +toString() String
        +equals(o : Object) boolean
        +hashCode() int
        +clone() Object
    }

    class Cosmetic {
        -type : String
        -family : String
        -isVegan : boolean
        +Cosmetic(id : int, name : String, price : double, stockLevel : int, type : String, family : String, isVegan : boolean)
        +getType() String
        +setType(type : String) void
        +getFamily() String
        +setFamily(family : String) void
        +isVegan() boolean
        +setVegan(vegan : boolean) void
        +compareTo(p : Product) int
        +toString() String
        +equals(o : Object) boolean
        +hashCode() int
        +clone() Object
    }

    class OutOfStockException {
        -medicationName : String
        -requestedQuantity : int
        -availableQuantity : int
        +OutOfStockException(medicationName : String, requestedQuantity : int, availableQuantity : int)
        +getShortfall() int
        +getMessage() String
    }

    class RuntimeException {
        <<java.lang>>
    }

    class CosmeticNameComparator {
        +compare(c1 : Cosmetic, c2 : Cosmetic) int
    }

    class Main {
        +main(args : String[]) void$
    }

    Product ..|> Sellable : implements
    Product ..|> Cloneable : implements
    Product ..|> Comparable~Product~ : implements

    Medicine --|> Product : extends
    Medicine ..|> Cloneable : implements

    PrescriptionMedication --|> Medicine : extends
    PrescriptionMedication ..|> Cloneable : implements

    OvertheCounterMedication --|> Medicine : extends
    OvertheCounterMedication ..|> Cloneable : implements

    Cosmetic --|> Product : extends
    Cosmetic ..|> Cloneable : implements

    OutOfStockException --|> RuntimeException : extends

    CosmeticNameComparator ..|> Comparator~Cosmetic~ : implements

    Product ..> OutOfStockException : throws

    Main ..> Product : uses
    Main ..> OvertheCounterMedication : creates
    Main ..> PrescriptionMedication : creates
    Main ..> Cosmetic : creates

    CosmeticNameComparator ..> Cosmetic : compares
```

---

## Projektstruktur

```
src/
├── main/java/org/example/
│   ├── Product.java                  — Abstrakte Basisklasse für alle Produkte
│   ├── Sellable.java                 — Interface für verkäufliche Produkte
│   ├── Medicine.java                 — Abstrakte Klasse für Medikamente
│   ├── PrescriptionMedication.java   — Verschreibungspflichtige Medikamente
│   ├── OvertheCounterMedication.java — Rezeptfreie Medikamente
│   ├── Cosmetic.java                 — Kosmetikprodukte
│   ├── OutOfStockException.java      — Custom Exception bei fehlendem Vorrat
│   ├── CosmeticNameComparator.java   — Comparator für Sortierung nach Name
│   └── Main.java                     — Hauptprogramm mit Demonstrationen
└── test/java/org/example/
    ├── ProductTest.java              — JUnit Tests für Produkt-Funktionalität
    ├── CosmeticTest.java             — JUnit Tests für Kosmetik-Klasse
    └── IntegrationTest.java          — Integrations-Tests
```

---

## Build & Ausführung

```bash
# Build
./gradlew build

# Ausführen
./gradlew run

# Tests ausführen
./gradlew test
```
