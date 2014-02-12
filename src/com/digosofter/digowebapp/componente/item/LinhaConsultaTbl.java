are (in) float angle))
     ((return (expression float sin (var_ref angle)))))

   (signature vec2
     (parameters
       (declare (in) vec2 angle))
     ((return (expression vec2 sin (var_ref angle)))))

   (signature vec3
     (parameters
       (declare (in) vec3 angle))
     ((return (expression vec3 sin (var_ref angle)))))

   (signature vec4
     (parameters
       (declare (in) vec4 angle))
     ((return (expression vec4 sin (var_ref angle)))))
))
                    ((function sign
   (signature float
     (parameters
       (declare (in) float x))
     ((return (expression float sign (var_ref x)))))

   (signature vec2
     (parameters
       (declare (in) vec2 x))
     ((return (expression vec2 sign (var_ref x)))))

   (signature vec3
     (parameters
       (declare (in) vec3 x))
     ((return (expression vec3 sign (var_ref x)))))

   (signature vec4
     (parameters
       (declare (in) vec4 x))
     ((return (expression vec4 sign (var_ref x)))))

   (signature int
     (parameters
       (declare (in) int x))
     ((return (expression int sign (var_ref x)))))

   (signature ivec2
     (parameters
       (declare (in) ivec2 x))
     ((return (expression ivec2 sign (var_ref x)))))

   (signature ivec3
     (parameters
       (declare (in) ivec3 x))
     ((return (expression ivec3 sign (var_ref x)))))

   (signature ivec4
     (parameters
       (declare (in) ivec4 x))
     ((return (expression ivec4 sign (var_ref x)))))
))

            ((function shadow2DRectProjGradARB
   (signature vec4
     (parameters
       (declare (in) sampler2DRectShadow sampler) 
       (declare (in) vec4 P) 
       (declare (in) vec2 dPdx) 
       (declare (in) vec2 dPdy) )
     ((return (txd vec4 (var_ref sampler) (swiz xy (var_ref P)) 0 (swiz w (var_ref P)) (swiz z (var_ref P)) ((var_ref dPdx) (var_ref dPdy)) ))))

))
                ((function shadow2DRectProj
   (signature vec4
     (parameters
       (declare (in) sampler2DRectShadow sampler) 
       (declare (in) vec4 P) )
     ((return (tex vec4 (var_ref sampler) (swiz xy (var_ref P)) 0 (swiz w (var_ref P)) (swiz z (var_ref P)) ))))

))
                         ((function shadow2DRectGradARB
   (signature vec4
     (parameters
       (declare (in) sampler2DRectShadow sampler) 
       (declare (in) vec3 P) 
       (declare (in) vec2 dPdx) 
       (declare (in) vec2 dPdy) )
     ((return (txd vec4 (var_ref sampler) (swiz xy (var_ref P)) 0 1 (swiz z (var_ref P)) ((var_ref dPdx) (var_ref dPdy)) ))))

))
       ((function shadow2DRect
   (signature vec4
     (parameters
       (declare (in) sampler2DRectShadow sampler) 
       (declare (in) vec3 P) )
     ((return (tex vec4 (var_ref sampler) (swiz xy (var_ref P)) 0 1 (swiz z (var_ref P)) ))))

))
                ((function shadow2DProjLod
   (signature vec4
     (parameters
       (declare (in) sampler2DShadow sampler) 
       (declare (in) vec4 P) 
       (declare (in) float lod) )
     ((return (txl vec4 (var_ref sampler) (swiz xy (var_ref P)) 0 (swiz w (var_ref P)) (swiz z (var_ref P)) (var_ref lod) ))))

))
               ((function shadow2DProjGradARB
   (signature vec4
     (parameters
       (declare (in) sampler2DShadow sampler) 
       (declare (in) vec4 P) 
       (declare (in) vec2 dPdx) 
       (declare (in) vec2 dPdy) )
     ((return (txd vec4 (var_ref sampler) (swiz xy (var_ref P)) 0 (swiz w (var_ref P)) (swiz z (var_ref P)) ((var_ref dPdx) (var_ref dPdy)) ))))

))
                        ((function shadow2DProj
   (signature vec4
     (parameters
       (declare (in) sampler2DShadow sampler) 
       (declare (in) vec4 P) )
     ((return (tex vec4 (var_ref sampler) (swiz xy (var_ref P)) 0 (swiz w (var_ref P)) (swiz z (var_ref P)) ))))

   (signature vec4
     (parameters
       (declare (in) sampler2DShadow sampler) 
       (declare (in) vec4 P) 
       (declare (in) float bias) )
     ((return (txb vec4 (var_ref sampler) (swiz xy (var_ref P)) 0 (swiz w (var_ref P)) (swiz z (var_ref P)) (var_ref bias) ))))

))
            ((function shadow2DLod
   (signature vec4
     (parameters
       (declare (in) sampler2DShadow sampler) 
       (declare (in) vec3 P) 
       (declare (in) float lod) )
     ((return (txl vec4 (var_ref sampler) (swiz xy (var_ref P)) 0 1 (swiz z (var_ref P)) (var_ref lod) ))))

))
      ((function shadow2DGradARB
   (signature vec4
     (parameters
       (declare (in) sampler2DShadow sampler) 
       (declare (in) vec3 P) 
       (declare (in) vec2 dPdx) 
       (declare (in) vec2 dPdy) )
     ((return (txd vec4 (var_ref sampler) (swiz xy (var_ref P)) 0 1