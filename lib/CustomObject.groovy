import groovy.transform.Immutable
import nextflow.io.ValueObject
import nextflow.util.KryoHelper

@ValueObject
@Immutable(copyWith=true, knownImmutables = ['name', 'r1', 'r2'])
class CustomObject {
    static {
        // Register this class with the Kryo framework that serializes and deserializes objects
        // that pass through channles. This allows for caching when this object is used.
        KryoHelper.register(CustomObject)
    }
    String name
    /** The path to the read one FASTQ */
    Path r1
    /** The path to the read two FASTQ */
    Path r2
}