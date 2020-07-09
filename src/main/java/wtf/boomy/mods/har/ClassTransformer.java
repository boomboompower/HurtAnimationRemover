package wtf.boomy.mods.har;

import net.minecraft.launchwrapper.IClassTransformer;

import net.minecraftforge.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

public class ClassTransformer implements IClassTransformer {
    
    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes) {
        
        if (transformedName.equalsIgnoreCase("net.minecraft.client.renderer.EntityRenderer")) {
            ClassReader reader = new ClassReader(bytes);
            ClassNode classNode = new ClassNode();
            reader.accept(classNode, ClassReader.SKIP_FRAMES);
    
            classNode.methods.forEach(method -> {
                String methodName = FMLDeobfuscatingRemapper.INSTANCE.mapMethodName(classNode.name, method.name, method.desc);
                
                // Basically we are telling the method to return as soon as its called
                // ignoring all the actual code after the method.
                if (methodName.equals("hurtCameraEffect")) {
                    System.out.println("Patching " + methodName);
                    
                    method.instructions.insertBefore(method.instructions.getFirst(), new InsnNode(Opcodes.RETURN));
                    
                    System.out.println("Patched " + methodName);
                }
            });
    
            ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
            classNode.accept(writer);
            return writer.toByteArray();
        }
        
        return bytes;
    }
}
